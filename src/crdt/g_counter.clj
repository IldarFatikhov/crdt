(ns crdt.g-counter)

(defn g-counter []
  (let [node-id (keyword (str (java.util.UUID/randomUUID)))]
    (atom {node-id 0})))

(defn increment-g-counter
  [g-counter node-id value]
  (let [increment-func (fn [current-val] (+ current-val value))]
    (swap! g-counter update-in [node-id] increment-func)))
