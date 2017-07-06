(ns crdt.g-counter)

(defn g-counter []
  (let [node-id (keyword (str (java.util.UUID/randomUUID)))]
    (atom {node-id 0})))

(defn increment-g-counter
  [g-counter node-id value-to-add]
  (let [increment-func (fn [current-val] (+ current-val value-to-add))]
    (swap! g-counter update-in [node-id] increment-func)))

(defn merge-g-counter
  [g-counter another-g-counter]
  (atom (merge @g-counter @another-g-counter)))

(defn value [g-counter]
  (let [g-counter-state @g-counter]
    (reduce + (vals g-counter-state))))
