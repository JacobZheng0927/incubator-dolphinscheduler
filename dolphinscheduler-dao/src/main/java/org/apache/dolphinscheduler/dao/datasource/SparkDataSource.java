/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.dao.datasource;

import org.apache.dolphinscheduler.common.Constants;
import org.apache.dolphinscheduler.common.enums.DbType;
import org.apache.dolphinscheduler.common.utils.CommonUtils;

import java.sql.Connection;

/**
 * data source of spark
 */
public class SparkDataSource extends BaseDataSource {

    /**
     * gets the JDBC url for the data source connection
     * @return jdbc url
     */
    @Override
    public String driverClassSelector() {
        return Constants.ORG_APACHE_HIVE_JDBC_HIVE_DRIVER;
    }

    /**
     * @return db type
     */
    @Override
    public DbType dbTypeSelector() {
        return DbType.SPARK;
    }

    /**
     * the data source test connection
     * @return Connection Connection
     * @throws Exception Exception
     */
    @Override
    public Connection getConnection() throws Exception {
        CommonUtils.loadKerberosConf();
        return super.getConnection();
    }
}
