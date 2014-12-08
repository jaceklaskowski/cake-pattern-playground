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
1. [Composition over inheritance (very rarely, though)](http://youtu.be/yLbdw06tKPQ?t=30m52s)

    > Basically, whenever you have a module that has some thing that it depends on, but that thing has state which needs to be shared with other modules.
    > Other things that are outside of your cake or rather instances of the module.
    > Whenever you find yourself in such a situation, you cannot use inheritance anymore. You have to use composition at some level.
    > There has to be a val inside your module that is another module, rather than bringing it in with `with` or `extends`. That sort of thing happens on occasion.

1. `val` or an input parameter to a method of a trait are interchangeable.

        trait SystemModule {
            val userModule: UserModule

            def doStuff() = {
                // use userModule
            }
        }

    or

        trait SystemModule {
            def doStuff(userModule: UserModule) = {
                // use userModule
            }
        }

### Unsorted

[Traits make modules first-class](http://youtu.be/yLbdw06tKPQ?t=35m3s)