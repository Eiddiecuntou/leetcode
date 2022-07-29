package com.cuntou.贪心算法;

/**
 * @ClassName : _621_task_scheduler  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/23  15:22
 */

public class _621_task_scheduler {
     /* 621. 任务调度器
    给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。
    其中每个字母表示一种不同种类的任务。
    任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
    在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。

    然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，
    因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

    你需要计算完成所有任务所需要的 最短时间 。

    示例 1：
    输入：tasks = ["A","A","A","B","B","B"], n = 2
    输出：8
    解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
         在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，
         而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。

    示例 2：
    输入：tasks = ["A","A","A","B","B","B"], n = 0
    输出：6
    解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
    ["A","A","A","B","B","B"]
    ["A","B","A","B","A","B"]
    ["B","B","B","A","A","A"]
    ...
    诸如此类

    示例 3：
    输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
    输出：16
    解释：一种可能的解决方案是：
         A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命)
         -> (待命) -> A -> (待命) -> (待命) -> A
     
    提示：
    1 <= task.length <= 10^4
    tasks[i] 是大写英文字母
    n 的取值范围为 [0, 100]
     */
    //贪心的策略的话
    //每一次可以安排出现次数最多的
    //n = 2;
    //完成任务所需要的最短的时间 = 待命的任务数 + 所有的任务数
    //每次安排出现次数最多的次数
    //贪心的安排出现次数最多的次数
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int maxCount = 0;// 出现次数最多的任务出现的次数
        int countMax = 0; // 出现次数最多的任务数
        for (char task : tasks) {
            counter[task - 'A']++;
            if (counter[task - 'A'] == maxCount) {
                countMax++;
            } else if (counter[task - 'A'] > maxCount) {
                maxCount = counter[task - 'A'];
                countMax = 1;
            }
        }

        int partCount = maxCount - 1;
        int partLength = n - (countMax - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxCount * countMax;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;

    }
    }
