# AD

# Termanology

term | describtion
--- | ---
Algorithm | A sequence of computational steps that transforms the input into the output

# Notation

symbol | describtion
:---: | ---
$O$ | Same as $\le$ (O) 
$\Omega$ | Same as $\ge$ (Omega)
$\Theta$ | Same as $=$ (Theta)
$o$ | Same as $<$ (Lille o)
$\omega$ | Same as $>$ (Lille omega)


# Sorting

Input: A sequence of $n$ numbers $\{a_1,a_2,...,a_n\}$
Outpur: A permutation (reordering) $\{a_1,a_2,...,a_n\}$ o the input sequnce such that $a'_1 \le a'_2 \le ... \le a'_n$

## Insertion sort

### Big O

- Best case: $O(n)$
- Worst case: $O(n^2)$

### Sudo code

```
for j = 2 to A.length
    key = A[j]
    // Insert A[j] into the sorted sequence A[1..j - 1]
    i = j - 1
    while i > 0 and A[i] > kay
        A[i + 1] = A [i]
        i = i - 1
    A[i + 1] = key
```

### Java

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


## Merge sort

### Big O

- Best case: $O(n log n)$
- Worst case: $O(n log n)$

### Sudo code

```
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

### Java

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

## Bubble sort

### Big O

- Worst case: $O(n^2)$
- Best case: $O(n)$

### Sudo code

```
for i = 1 to A.length
    for j = A.length - 1 downto i
        if A[j] < A[j - 1]
            swap A[j] and A[j - 1]
```

### Java

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