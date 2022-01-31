# DMAD



# L1

# Termanology

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

# Symbology

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


# Precedence

operator | precedence
:---: | :---:
$\neg{}$ | 1
$\wedge{}$ | 2
$\vee{}$ | 3
$\rightarrow{}$ | 4
$\leftrightarrow{}$ | 5


# Negation

$p$ | $\neg{p}$
:---: | :---:
T | F
F | T

# Conjunction

$p$ | $q$ | ${p}\wedge{q}$
:---: | :---: | :---:
T | T | T
T | F | F
F | T | F
F | F | F

# Disjunction (Inclusive)

$p$ | $q$ | ${p}\vee{q}$
:---: | :---: | :---:
T | T | T
T | F | T
F | T | T
F | F | F

# Disjunction (Exclusive)

$p$ | $q$ | ${p}\vee{q}$
:---: | :---: | :---:
T | T | F
T | F | T
F | T | T
F | F | F

# Conditional Statement

$p$ is the hypothesis

$q$ is the conclusion

$p$ | $q$ | ${p}\rightarrow{q}$
:---: | :---: | :---:
T | T | T
T | F | F
F | T | T
F | F | T


# Biconditional Statement

$p$ | $q$ | ${p}\leftrightarrow{q}$
:---: | :---: | :---:
T | T | T
T | F | F
F | T | F
F | F | T


# Tautology and Contradiction

$p$ | $\neg{p}$ | ${p}\vee{\neg{p}}$ | ${p}\wedge{\neg{p}}$
:---: | :---: | :---: | :---:
T | F | T | F
F | T | T | F

# Logical Equivalences

${p}\leftrightarrow{q}$ is a tautology

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
