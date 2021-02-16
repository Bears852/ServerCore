package info.xiaomo.gengine.thread.queue.action;

import info.xiaomo.gengine.thread.queue.IActionQueue;

/**
 * 延迟执行action
 *
 * @author laofan
 */
public abstract class DelayGameAction extends GameAction {

	/**
	 * 执行时间点
	 */
	protected long execTime;

	/**
	 * 延迟时间
	 */
	protected int delay;

	public DelayGameAction(IActionQueue<GameAction, DelayGameAction> queue, int delay) {
		super(queue);
		execTime = System.currentTimeMillis() + delay;
		this.delay = delay;
	}

	/**
	 * @param queue
	 * @param startTime         ：开始时间
	 * @param delay：推迟时间（单位：毫秒）
	 */
	public DelayGameAction(IActionQueue<GameAction, DelayGameAction> queue, long startTime, int delay) {
		super(queue);
		execTime = startTime + delay;
	}

	/**
	 * 判断是否时间到。可以执行。
	 *
	 * @param curTime
	 * @return ：true： 可以执行
	 */
	public boolean canExec(long curTime) {
		if (curTime >= execTime) {
			createTime = curTime;
			return true;
		}
		return false;
	}
}
