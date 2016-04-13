(def ROOT-DIR (subs *file* 0 (- (count *file*) (count "project.clj"))))
(def HADOOP-VERSION (-> ROOT-DIR (str "/../HADOOP-VERSION") slurp))
(def VERSION (-> ROOT-DIR (str "/../VERSION") slurp))

(defproject cascalog/cascalog-math VERSION
  :description "Math modules for Cascalog."
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories {"conjars.org" "http://conjars.org/repo"}
  :profiles {:1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7 {:denpedencies [[org.clojure/clojure "1.7.0"]]}
             :provided {:dependencies [[cascalog/cascalog-core ~VERSION]
                                       [org.apache.hadoop/hadoop-mapreduce-client-core ~HADOOP-VERSION]
                                       [org.apache.hadoop/hadoop-common ~HADOOP-VERSION]
                                       [org.apache.hadoop/hadoop-mapreduce-client-shuffle ~HADOOP-VERSION]]}
             :dev {:dependencies [[cascalog/midje-cascalog ~VERSION]
                                  [net.sourceforge.parallelcolt/parallelcolt "0.10.0"]]
                   :plugins [[lein-midje "3.1.3"]]}})
