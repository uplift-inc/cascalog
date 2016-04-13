(def ROOT-DIR (subs *file* 0 (- (count *file*) (count "project.clj"))))
(def HADOOP-VERSION (-> ROOT-DIR (str "/../HADOOP-VERSION") slurp))
(def VERSION (-> ROOT-DIR (str "/../VERSION") slurp))

(defproject cascalog/cascalog-more-taps VERSION
  :description "More taps for Cascalog"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :javac-options ["-target" "1.7" "-source" "1.7"]
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]
  :jar-exclusions [#"\.java$"]
  :repositories {"conjars.org" "http://conjars.org/repo"}
  :profiles {:1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.0"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0"]]}
             :provided {:dependencies [[cascalog/cascalog-core ~VERSION]
                                       [org.apache.hadoop/hadoop-mapreduce-client-core ~HADOOP-VERSION]
                                       [org.apache.hadoop/hadoop-common ~HADOOP-VERSION]
                                       [org.apache.hadoop/hadoop-mapreduce-client-shuffle ~HADOOP-VERSION]]}
             :dev {:plugins [[lein-midje "3.1.3"]]
                   :dependencies
                   [[cascalog/midje-cascalog ~VERSION]
                    [hadoop-util "0.3.0"]]}})
