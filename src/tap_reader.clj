(ns tap-reader)

(defn tap-reader
  [sym]
  `(do
     (tap> ^{:portal.viewer/default
             :portal.viewer/pprint}
            {(quote ~sym)
             ~sym})
     ~sym))
