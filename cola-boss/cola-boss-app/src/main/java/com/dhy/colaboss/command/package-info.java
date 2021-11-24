/**
 * This package contains CommandExecutors
 * which are used to process Command Request.
 *
 * Command Query Responsibility Seperation（命令查询职责分离）
 *
 * 这层既和 domain层交互，又负责持久化行为工作，在这里将 domain层
 * 的实体 送入 gateway接口，通过gateway接口实现 持久化
 *
 * 这里是命令部分
 *
 * @author fulan.zjf
 */
package com.dhy.colaboss.command;