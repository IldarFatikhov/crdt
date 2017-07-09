(ns crdt.g-set)

(defn g-set []
  (atom (set [])))

(defn add-to-g-set [g-set value-to-add]
  (swap! g-set conj value-to-add))

(defn value [g-set]
  @g-set)
