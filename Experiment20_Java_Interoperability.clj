
;; Lab 11 - Experiment 20
;; Java Interoperability in Clojure

(ns experiment20-java-interop)

(println "JAVA INTEROPERABILITY IN CLOJURE")
(println "--------------------------------")

;; 1. Calling Java static methods
(println "Absolute value of -25:" (Math/abs -25))
(println "Larger number:" (Math/max 15 30))
(println "Current time in milliseconds:" (System/currentTimeMillis))

;; 2. Creating Java object instances
(def numbers (java.util.ArrayList.))
(def student (java.util.HashMap.))

;; 3. Calling instance methods on Java objects
(.add numbers 10)
(.add numbers 20)
(.add numbers 30)

(.put student "name" "Rahul")
(.put student "course" "Clojure")

(println "Java ArrayList:" numbers)
(println "Number of items:" (.size numbers))
(println "First item:" (.get numbers 0))
(println "Java HashMap:" student)
(println "Student name:" (.get student "name"))

;; 4. Converting between Java and Clojure collections
(def clojure-vector (vec numbers))
(def clojure-map (into {} student))

(println "Java ArrayList converted to Clojure vector:" clojure-vector)
(println "Java HashMap converted to Clojure map:" clojure-map)

;; Converting Clojure collections back to Java collections
(def java-list-again (java.util.ArrayList.))
(doseq [item [100 200 300]]
  (.add java-list-again item))

(def java-map-again (java.util.HashMap.))
(doseq [[key value] {:name "Aman" :course "Clojure"}]
  (.put java-map-again (name key) value))

(println "Clojure vector converted to Java ArrayList:" java-list-again)
(println "Clojure map converted to Java HashMap:" java-map-again)

(println "--------------------------------")
(println "Experiment 20 completed successfully.")
