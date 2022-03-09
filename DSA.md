# AD

## Termanology

term | describtion
--- | ---
Algorithm | A sequence of computational steps that transforms the input into the output

## Notation

symbol | describtion
:---: | ---
$O$ | Same as $\le$ (O)
$\Omega$ | Same as $\ge$ (Omega)
$\Theta$ | Same as $=$ (Theta)
$o$ | Same as $<$ (Lille o)
$\omega$ | Same as $>$ (Lille omega)

## DataStructures

### Binary-Search-Trees

### Red-Black trees

1. Every node is either red or black.
2. The root is black.
3. Every leaf (NIL) is black.
4. If a node is red, then both its children are black.
5. For each node, all simple paths from the node to descendant leaves contain the
same number of black nodes.

#### Insert z

- All new nodes are red

case 0: tree is empty
case 1: uncle is red -> color flip
case 2: uncle is black and path is right, right -> left rotate
case 3: uncle is black and path is left, left -> right rotate
case 4: uncle is black and path is left, right -> right-left rotate
case 5: uncle is black and path is right, left -> left-right rotate

## Sorting

Input: A sequence of $n$ numbers $\{a_1,a_2,...,a_n\}$
Outpur: A permutation (reordering) $\{a_1,a_2,...,a_n\}$ o the input sequnce such that $a'_1 \le a'_2 \le ... \le a'_n$

### Insertion sort

Big O

- Best case: $O(n)$
- Worst case: $O(n^2)$

---

Pseudo code

```text
for j = 2 to A.length
    key = A[j]
    // Insert A[j] into the sorted sequence A[1..j - 1]
    i = j - 1
    while i > 0 and A[i] > kay
        A[i + 1] = A [i]
        i = i - 1
    A[i + 1] = key
```

---

Java

```java
for(int j = 1; j < A.size(); j++) {
    int key = A.get(j);
    int i = j - 1;
    while(i >= 0 && A.get(i) > key) {
        A.set(i + 1, A.get(i));
        i = i - 1;
    }
    A.set(i + 1, key);
}
```

### Merge sort

Big O

- Best case: $O(n \log n)$
- Worst case: $O(n \log n)$

---

Pseudo code

```text
Merge(A,left,middle,right)
    n_1 = middle - left + 1
    n_2 = right - middle
    let L[1..n_1 + 1] and R[1..n_2 + 1] be new arrays
    for i = 1 to n_1
        L[i] = A[left + i - 1]
    for j = 1 to n_2
        R[j] = A[middle + j]
    L[n_1 + 1] = infinity
    R[n_2 + 1] = infinity
    left_index = 1
    right_index = 1
    sorted_index = left
    while sorted_index < right
        if L[left_index] <= R[right_index]
            A[sorted_index] = L[left_index]
            left_index = left_index + 1
        else 
            A[sorted_index] = R[right_index]
            right_index = right_index + 1
        sorted_index = sorted_index + 1

    while(left_index < n1) 
            A[sorted_index] = L[left_index]
            sorted_index = sorted_index + 1
            left_index = left_index + 1
        
        while right_index < n2
            A[sorted_index] = R[right_index] 
            sorted_index = sorted_index + 1
            right_index = right_index +1

Merge-Sort(A,left,right)
    if left < right 
        middle = floor((left + right) / 2)
        Merge-Sort(A,left,middle)
        Merge-Sort(A,middle + 1,right)
        Merge(A,left,middle,right)
```

---

Java

```java
private static void merge(ArrayList<Integer> A, int left, int middle, int right) {
    int n1 = middle - left + 1;
    int n2 = right - middle;
    ArrayList<Integer> L = new ArrayList<>();
    ArrayList<Integer> R = new ArrayList<>();
    for (int i = 0; i < n1; i++) {
        L.add(A.get(left + i));
    }
    for (int j = 0; j < n2; j++) {
        R.add(A.get(middle + j + 1));
    }
    L.add(Integer.MAX_VALUE);
    R.add(Integer.MAX_VALUE);
    int left_index = 0;
    int right_index = 0;
    int sorted_index = left;
    while (sorted_index < right) {
        if (L.get(left_index) <= R.get(right_index)) {
            A.set(sorted_index, L.get(left_index));
            left_index++;
        }
        else {
            A.set(sorted_index, R.get(right_index));
            right_index++;
        }
        sorted_index++;
    }
    while(left_index < n1) {
        A.set(sorted_index, L.get(left_index));
        sorted_index++;
        left_index++;
    }
    while(right_index < n2) {
        A.set(sorted_index, R.get(right_index));
        sorted_index++;
        right_index++;
    }
}
private static void mergeSort(ArrayList<Integer> A, int left, int right) {
    if(left < right) {
        int middle = (int)Math.floor((left + right) / 2f);
        mergeSort(A,left,middle);
        mergeSort(A,middle + 1,right);
        merge(A,left,middle,right);
    }
}
```

### Bubble sort

Big O

- Worst case: $O(n^2)$
- Best case: $O(n)$

---

Pseudo code

```text
for i = 1 to A.length
    for j = A.length - 1 downto i
        if A[j] < A[j - 1]
            swap A[j] and A[j - 1]
```

---

Java

```java
private static void bubbleSort(ArrayList<Integer> A) {
    for(int i = 0; i < A.size(); i++) {
        for(int j = A.size() - 1; j > i; j--) {
            if(A.get(j) < A.get(j - 1)) {
                swap(A,j,j - 1);
            }
        }
    }
}
private static void swap(ArrayList<Integer> A, int i, int j) {
    int temp = A.get(i);
    A.set(i,A.get(j));
    A.set(j,temp);
}
```

### Quick sort

Big O

- Worst case: $O(n^2)$
- Best case: $O(n \log n)$

---

Pseudo code

```text
Quick-sort(A,p,r)
    if p < r
        q = PARTITION(A,p,r)
        QUICKSORT(A,p,q-1)
        QUICKSORT(A,q+1,r)


Partition(A,p,r)
    x = A[r]
    i = p - 1
    for j = p to r - 1
        if A[j] <= x
            i = i + 1
            exchange A[i] with A[j]
    exchange A[i + 1] with A[r]
    return i + 1
```

---

Java

```java
private static void quickSort(ArrayList<Integer> A, int p, int r) {
        if (p < r) {
            int q = partition(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }
    private static int partition(ArrayList<Integer> A, int p, int r) {
        int x = A.get(r);
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A.get(j) <= x) {
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,r);
        return i + 1;
    }
```

### Heap sort

Big O

- Worst case: $O(n \log n)$
- Best case: $O(n \log n)$ (distinct keys)
- Best case: $O(n)$ (equal keys)

---

Pseudo code

```text
PARRENT(i)
    return floor(i/2)

LEFT(i)
    return 2i

RIGHT(i)
    return 2i + 1

MAX-HEAPIFY(A,i)
    l = LEFT(i)
    r = RIGHT(i)
    if l <= A.heap-size and A[l] > A[i]
        largest = l
    else
        largest = i
    if r <= A.heap-size and A[r] > A[largest]
        largest = r
    if largest =/= i
        exchange A[i] with A[largest]
        MAX-HEAPIFY(A,largest)

HEAPSORT(A)
    BUILD-MAX-HEAP(A)
    for i = A.length downto 2
        exchange A[1] with A[i]
        A.heap-size = A.heap-size - 1
        MAX-HEAPIFY(A,1)
```

---

Java

```java

```

### Counting sort

Big O

---

Pseudo code

```text
COUNTING-SORT(A,B,k)
    for i = 0 to k
        C[i] = 0
    for j = 1 to A.length
        C[A[j]]++
    for i = 1 to k
        C[i] = C[i] + C [i - 1]
    for j = A.length downto 1
        B[C[A[j]]] = A[j]
        C[A[j]] = C[A[j]] - 1
```

---

Java

```java
public static void countingSort(ArrayList<Integer> A) {
    int k = A.size()-1;
    ArrayList<Integer> B = new ArrayList<>();
    ArrayList<Integer> C = new ArrayList<>();
    for (int i = 0; i <= k; i++) {
        C.add(0);
    }
    for (int i = 0; i < A.size(); i++) {
        B.add(0);
    }
    for (int j = 0; j < A.size(); j++) {
        C.set(A.get(j), C.get(A.get(j)) + 1);
    }
    for (int i = 1; i <= k; i++) {
        C.set(i, C.get(i) + C.get(i - 1));
    }
    for (int j = A.size() - 1; j >= 0; j--) {
        B.set(C.get(A.get(j)) - 1, A.get(j));
        C.set(A.get(j), C.get(A.get(j)) - 1);
    }
    A = B;
}
```

### Radix sort

Big O

- Worst case: $O(nk/d)$
- Best case: $O(nk/d)$

---

Pseudo code

---

Java
