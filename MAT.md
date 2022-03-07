# DM

## Termanology

term | describtion
--- | ---
Proposition | A sentence that declares a fact
Propositional variables (or sentential variables) | Often expressed with: p,q,r,s,...
Atomic propositions | Propositions that cannot be expressed in terms of simpler proposotions
Propositional calculus/logic | The area of logic dealing with propositions
Compound propositions | Combining one or more propositions
Logical operators | Used to combine one or more propositions
Equivalent | Two propositions always have the same truth values
Tautology | A compound proposition that is always true, no matter the values of its propositional variables
Contradicion | A compound proposition that is always false, no matter the values of its propositional variables
Contingency | A compund proposition what is neither a tautology nor a contradition
Satisfiable | When it is posible to assign variables of a compound propositions to make the it true
Unsatisfiable | When it is not posible to assign variables of a compound propositions to make the it true
Predicate Logic | Statements involving variables $P(x)$
Quantification | Create a proposition from a propositional function
Universal Quantifier | $P(x)$ for all values of $x$ in the domain
Existential quantifier | There exists an element $x$ in the domain such that $P(x)$

## Symbology

$p$ is a proposition

$q$ is a proposition

symbol | describtions
--- | ---
T | True
F | False
$\neg{p}$ or $\bar{p}$ | Negation, Not
${p}\wedge{q}$ | Conjunction, And
${p}\vee{q}$ | Disjunctions, Or (Inclusive)
${p}\oplus{q}$ | Disjunctions, Or (Exclusive)
${p}\rightarrow{q}$ | Conditional statement (if $p$, then $q$)
${q}\rightarrow{p}$ | Converse
$\neg{q}\rightarrow{\neg{p}}$ | Contrapositive
$\neg{p}\rightarrow{\neg{q}}$ | Inverse
${p}\leftrightarrow{q}$ | Biconditional statement ($p$ if and only if $q$)
${p}\equiv{q}$ | Logically equivalent
$\forall{xP(x)}$ | Universal quantifier (for all)
$\exists{xP(x)}$ | Existential quantifier (there exists)

## Precedence

operator | precedence
:---: | :---:
$\neg{}$ | 1
$\wedge{}$ | 2
$\vee{}$ | 3
$\rightarrow{}$ | 4
$\leftrightarrow{}$ | 5

## Negation

$p$ | $\neg{p}$
:---: | :---:
T | F
F | T

## Conjunction

$p$ | $q$ | ${p}\wedge{q}$
:---: | :---: | :---:
T | T | T
T | F | F
F | T | F
F | F | F

## Disjunction (Inclusive)

$p$ | $q$ | ${p}\vee{q}$
:---: | :---: | :---:
T | T | T
T | F | T
F | T | T
F | F | F

## Disjunction (Exclusive)

$p$ | $q$ | ${p}\vee{q}$
:---: | :---: | :---:
T | T | F
T | F | T
F | T | T
F | F | F

## Conditional Statement

$p$ is the hypothesis

$q$ is the conclusion

$p$ | $q$ | ${p}\rightarrow{q}$
:---: | :---: | :---:
T | T | T
T | F | F
F | T | T
F | F | T

## Biconditional Statement

$p$ | $q$ | ${p}\leftrightarrow{q}$
:---: | :---: | :---:
T | T | T
T | F | F
F | T | F
F | F | T

## Tautology and Contradiction

$p$ | $\neg{p}$ | ${p}\vee{\neg{p}}$ | ${p}\wedge{\neg{p}}$
:---: | :---: | :---: | :---:
T | F | T | F
F | T | T | F

${p}\leftrightarrow{q}$ is a tautology

## Logical Equivalences

equivalence | name
:--: | ---
$p\wedge{T}\equiv{p}$ | Identity law
$p\vee{F}\equiv{p}$ | Identity law
$p\vee{T}\equiv{T}$ | Domination law
$p\wedge{F}\equiv{F}$ | Domination law
$p\vee{p}\equiv{p}$ | Idemopten law
$p\wedge{p}\equiv{p}$ | Idemopten law
$\neg{(\neg{p})}\equiv{p}$ | Double negation law
$p\vee{q}\equiv{q\vee{p}}$ | Commutative law
$p\wedge{q}\equiv{q\wedge{p}}$ | Commutative law
$(p\vee{q})\vee{r}\equiv{p\vee{(q\vee{r})}}$ | Associative law
$(p\wedge{q})\wedge{r}\equiv{p\wedge{(q\wedge{r})}}$ | Associative law
$p\vee{(q\wedge{r})}\equiv{(p\vee{q})\wedge{(p\vee{r})}}$ | Distributive law
$p\wedge{(q\vee{r})}\equiv{(p\wedge{q})\vee{(p\wedge{r})}}$ | Distributive law
$\neg{(p\wedge{q})}\equiv{\neg{p}\vee{\neg{q}}}$ | De Morgan's law
$\neg{(p\vee{q})}\equiv{\neg{p}\wedge{\neg{q}}}$ | De Morgan's law
$p\vee{(p\wedge{q})}\equiv{p}$ | Absorption law
$p\wedge{(p\vee{q})}\equiv{p}$ | Absorption law
$p\vee{\neg{p}}\equiv{T}$ | Negation law
$p\wedge{\neg{p}}\equiv{F}$ | Negation law

$\vee_{j=1}^{n}{p_j} = p_1\vee{p_2}\vee{...}\vee{p_n}$

$\wedge_{j=1}^{n}{p_j} = p_1\wedge{p_2}\wedge{...}\wedge{p_n}$

$\neg{(\vee_{j=1}^{n}{p_j})}\equiv{\wedge_{j=1}^{n}{\neg{p_j}}}$

$\neg{(\wedge_{j=1}^{n}{p_j})}\equiv{\vee_{j=1}^{n}{\neg{p_j}}}$

### Quantifiers

statment | when true | when false
---|---|---
$\forall x P(x)$ | $P(x)$ is true for every $x$ | There is an $x$ where $P(x)$ is false
$\exists x P(x)$ | There is an $x$ where $P(x)$ is true | $P(x)$ is false for every $x$
$\exists !xP(x)$ | There is a unique $x$ where $P(x)$ is true | More than one $x$ where $P(x)$ is true or $P(x)$ is false for every $x$

### De Morgan’s Laws for Quantifiers

negation | equivalant statment | then true | when false
---|---|---|---
$\neg \exists x P(x)$ | $\forall x \neg P(x)$ | For every $x$, $P(x)$ is false | Ther is an $x$ where $P(x)$ is true
$\neg \forall x P(x)$ | $\exists x \neg P(x)$ | There is an $x$ where $P(x)$ is false | $P(x)$ is true for every $x$

### Quantifications of two variables

statement | when true | when false
---|---|---
$\forall x \forall y P(x,y)$ | $P(x,y)$ is true for every pari $x,y$ | There is a pair $x,y$ for which $P(x,y)$ is false
$\forall y \forall x P(x,y)$ | $P(x,y)$ is true for every pari $x,y$ | There is a pair $x,y$ for which $P(x,y)$ is false
$\forall x \exists y P(x,y)$ | For every $x$ there is a $y$ for which $P(x,y)$ is true | Ther is an $x$ such that $P(x,y)$ if false for evey $y$
$\exists x \forall y P(x,y)$ | There is an $x$ for which $P(x,y)$ is true for every $y$ | For every $x$ there is a $y$ for which $P(x,y)$ is false
$\exists x \exists y P(x,y)$ | There is a pair $x,y$ for which $P(x,y)$ is true | $P(x,y)$ is false for every pair $x,y$
$\exists y \exists x P(x,y)$ | There is a pair $x,y$ for which $P(x,y)$ is true | $P(x,y)$ is false for every pair $x,y$

## Proofs

### Direct proof

$p \Rightarrow q$

### Proof by Contraposition

$(p \Rightarrow q) \equiv (\lnot q \Rightarrow \lnot p)$

### Proof by Contradiction

$(\lnot p \Rightarrow F) \Rightarrow p$

### Proof by Induction

Basis:

$P(0): 2^0 = 2^{0+1} - 1 = 1$

$P(k):2^0 + 2^1 + ... + 2^{k-1} + 2^k = 2^{k+1} - 1$

$P(k+1):2^0 + 2^1 + ... + 2^{k-1} + 2^k + 2^{k+1} = 2^{k+1} + 2^{k+1} - 1 = 2^{k+2} - 1$

$\forall k \in \N: (P(k) \Rightarrow P(k+1))$
