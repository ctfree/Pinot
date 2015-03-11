/**
 * Copyright (C) 2014-2015 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.core.data.manager.offline;

import java.util.List;
import java.util.concurrent.ExecutorService;

import com.linkedin.pinot.common.segment.SegmentMetadata;
import com.linkedin.pinot.core.data.manager.config.ResourceDataManagerConfig;
import com.linkedin.pinot.core.indexsegment.IndexSegment;


/**
 * ResourceDataManager interface.
 * Provided interfaces to do operations on segment level.
 *
 * @author xiafu
 *
 */
public interface ResourceDataManager {

  /**
   * Initialize ResourceDataManager based on given config.
   *
   * @param resourceDataManagerConfig
   */
  public void init(ResourceDataManagerConfig resourceDataManagerConfig);

  public void start();

  public void shutDown();

  public boolean isStarted();

  /**
   * Adding an IndexSegment into the ResourceDataManager.
   *
   * @param indexSegmentToAdd
   */
  public void addSegment(IndexSegment indexSegmentToAdd);

  /**
   * Adding an SegmentMetadata into the ResourceDataManager.
   *
   * @param segmentMetaToAdd
   * @throws Exception
   */
  public void addSegment(SegmentMetadata segmentMetaToAdd) throws Exception;

  /**
   * Remove an IndexSegment/SegmentMetadata from the partition based on segmentName.
   * @param segmentNameToRemove
   */
  public void removeSegment(String segmentToRemove);

  /**
   *
   * @return all the segments in this ResourceDataManager.
   */
  public List<OfflineSegmentDataManager> getAllSegments();

  /**
   *
   * @return segments by giving a list of segment names in this ResourceDataManager.
   */
  public List<OfflineSegmentDataManager> getSegments(List<String> segmentList);

  /**
   *
   * @return a segment by giving the name of this segment in this ResourceDataManager.
   */
  public OfflineSegmentDataManager getSegment(String segmentName);

  /**
   *
   * give back segmentReaders, so the segment could be safely deleted.
   */
  public void returnSegmentReaders(List<String> segmentList);

  /**
   * @return ExecutorService for query.
   */
  public ExecutorService getExecutorService();

}
