# Tap Reader

Adds the tagged literal `#tap` that you can prefix a form with to send its value
to `tap>`.

You will need to do the following somewhere in your running repl to make sure
the tagged literal implementation is bound.
```
(require '[tap-reader])
```

Once that's done you can use it as follows to send forms to any `tap>` listener
you might have.

```
(let [x 10
      y #tap (* x 2)]
  #tap (+ 11 #tap y))

;; The following will be sent to your `tap>` listener:
;; {'(* x 2) 20}
;; {'y 20}
;; {'(+ 11 (do (clojure.core/tap> (quote y)) y)) 31}
```

The last one is a little funky because we've nested `#tap` calls, so the inner
one is expanded first and included as part of the form in the second call of `#tap`.
