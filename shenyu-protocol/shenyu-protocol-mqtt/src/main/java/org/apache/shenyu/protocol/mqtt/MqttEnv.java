/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shenyu.protocol.mqtt;

import org.apache.commons.lang3.StringUtils;

/**
 * mqtt env.
 */
public class MqttEnv {

    private static int port;

    private static int bossGroupThreadCount;

    private static int maxPayloadSize;

    private static int workerGroupThreadCount;

    private static String userName;

    private static String password;

    static {
        MqttServerConfiguration configuration = new MqttServerConfiguration();
        configuration.afterPropertiesSet();
    }

    /**
     * Whether userName and password are correct.
     * @param userName userName
     * @param passwordInBytes passwordInBytes
     * @return true is correct, false unavailable.
     */
    public static boolean isValid(final String userName, final byte[] passwordInBytes) {
        String password = new String(passwordInBytes);

        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(userName)) {
            return false;
        }

        return MqttEnv.userName.equals(userName) && MqttEnv.password.equals(password);
    }

    /**
     * get port.
     * @return port.
     */
    public int getPort() {
        return port;
    }

    /**
     * get bossGroupThreadCount.
     * @return bossGroupThreadCount
     */
    public int getBossGroupThreadCount() {
        return bossGroupThreadCount;
    }

    /**
     * get maxPayloadSize.
     * @return maxPayloadSize.
     */
    public int getMaxPayloadSize() {
        return maxPayloadSize;
    }

    /**
     * get workerGroupThreadCount.
     * @return workerGroupThreadCount
     */
    public int getWorkerGroupThreadCount() {
        return workerGroupThreadCount;
    }

    /**
     * get userName.
     * @return userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * get password.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set port.
     * @param port port
     */
    public void setPort(final int port) {
        MqttEnv.port = port;
    }

    /**
     * set bossGroupThreadCount.
     * @param bossGroupThreadCount bossGroupThreadCount
     */
    public void setBossGroupThreadCount(final int bossGroupThreadCount) {
        MqttEnv.bossGroupThreadCount = bossGroupThreadCount;
    }

    /**
     * set maxPayloadSize.
     * @param maxPayloadSize maxPayloadSize
     */
    public void setMaxPayloadSize(final int maxPayloadSize) {
        MqttEnv.maxPayloadSize = maxPayloadSize;
    }

    /**
     * set workerGroupThreadCount.
     * @param workerGroupThreadCount workerGroupThreadCount
     */
    public void setWorkerGroupThreadCount(final int workerGroupThreadCount) {
        MqttEnv.workerGroupThreadCount = workerGroupThreadCount;
    }

    /**
     * set userName.
     * @param userName userName
     */
    public void setUserName(final String userName) {
        MqttEnv.userName = userName;
    }

    /**
     * set password.
     * @param password password.
     */
    public void setPassword(final String password) {
        MqttEnv.password = password;
    }

}
