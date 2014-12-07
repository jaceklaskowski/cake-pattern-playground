cake-pattern-playground
=======================

Demo of the (in)famous Cake Pattern guided by [Cake Pattern: The Bakery from the Black Lagoon](https://www.youtube.com/watch?v=yLbdw06tKPQ) video.

## Notes from the talk

### Baby steps into Cake Pattern

1. Split codebase into top-level traits (a trait per file)
1. Use `extends` and `with` to construct modules. Dependencies are therefore:
    1. explicit
    1. documented
    1. type-checked
1. Use inner objects for namespacing (avoids name clashes)
