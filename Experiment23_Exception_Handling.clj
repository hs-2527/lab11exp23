
(ns experiment23-exception-handling)

(println "EXPERIMENT 23: Exception Handling and Error Management in Clojure")
(println "---------------------------------------------------------------")

(defn check-age [age]
  (when (< age 18)
    (throw (ex-info "Age must be 18 or above!"
                    {:error :invalid-age
                     :age age})))
  (str "Age accepted: " age))

(defn demo-exceptions []
  (try
    (try
      (/ 10 0)
      (catch ArithmeticException e
        (println "Caught ArithmeticException:" (.getMessage e))))

    (try
      (.toUpperCase ^String nil)
      (catch NullPointerException e
        (println "Caught NullPointerException:" (.getMessage e))))

    (try
      (check-age 16)
      (catch clojure.lang.ExceptionInfo e
        (println "Caught Custom Exception:" (ex-message e))
        (println "Exception Data:" (ex-data e))))

    (finally
      (println "Finally block: Exception handling completed."))))

(demo-exceptions)
