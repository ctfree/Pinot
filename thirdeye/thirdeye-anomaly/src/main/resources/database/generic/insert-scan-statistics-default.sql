INSERT INTO `%s`(
  name,
  description,
  collection,
  class_name,
  properties
) VALUES (
"scanstatistics",
"default settings (p<0.05, seasonal=168, pattern=%s)",
"%s",
"ScanStatisticsAnomalyDetectionFunction",
"# autogenerated properties
metric=%s
pValueThreshold=0.05
trainSize=35
trainUnit=DAYS
bucketSize=1
bucketUnit=HOURS
numSimulations=1000
seasonal=168
pattern=%s
"
);