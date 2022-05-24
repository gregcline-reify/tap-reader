# Tap Reader

Adds the tagged literal `#tap` that you can prefix a form with to send its value
to `tap>`.

You will need to do the following somewhere in your running repl to make sure
the tagged literal implementation is bound.
```
(require '[tap-reader])
```
