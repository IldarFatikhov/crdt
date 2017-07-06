(ns crdt.g-counter)

(defn counter []
  (atom {}))

(defn increment-counter
  "Increment counter"
  [counter-state]
  (let [counter-state-value @counter-state]
    (println counter-state-value)))
