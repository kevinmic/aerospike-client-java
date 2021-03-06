/* 
 * Copyright 2012-2015 Aerospike, Inc.
 *
 * Portions may be licensed to Aerospike, Inc. under one or more contributor
 * license agreements.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.aerospike.client.policy;

/**
 * Container object for transaction policy attributes used in all database
 * operation calls.
 */
public class Policy {
	/**
	 * Priority of request relative to other transactions.
	 * Currently, only used for scans.
	 */
	public Priority priority = Priority.DEFAULT;
	
	/**
	 * How replicas should be consulted in a read operation to provide the desired
	 * consistency guarantee. Default to allowing one replica to be used in the
	 * read operation.
	 */
	public ConsistencyLevel consistencyLevel = ConsistencyLevel.CONSISTENCY_ONE;

	/**
	 * Transaction timeout in milliseconds.
	 * This timeout is used to set the socket timeout and is also sent to the 
	 * server along with the transaction in the wire protocol.
	 * Default to no timeout (0).
	 */
	public int timeout;
	
	/**
	 * Maximum number of retries before aborting the current transaction.
	 * A retry is attempted when there is a network error other than timeout.  
	 * If maxRetries is exceeded, the abort will occur even if the timeout 
	 * has not yet been exceeded.  The default number of retries is 1.
	 */
	public int maxRetries = 1;

	/**
	 * Milliseconds to sleep between retries if a transaction fails and the 
	 * timeout was not exceeded.  Enter zero to skip sleep.
	 * The default sleep between retries is 500 ms.
	 */
	public int sleepBetweenRetries = 500;
	
	/**
	 * Send user defined key in addition to hash digest on both reads and writes.  
	 * The default is to not send the user defined key.
	 */
	public boolean sendKey;
	
	/**
	 * Copy policy from another policy.
	 */
	public Policy(Policy other) {
		this.priority = other.priority;
		this.consistencyLevel = other.consistencyLevel;
		this.timeout = other.timeout;
		this.maxRetries = other.maxRetries;
		this.sleepBetweenRetries = other.sleepBetweenRetries;
		this.sendKey = other.sendKey;
	}
	
	/**
	 * Default constructor.
	 */
	public Policy() {
	}
}
