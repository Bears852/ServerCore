package info.xiaomo.gameCore.base.concurrent.queue;

/**
 * 任务队列接口</br>
 * 所有实现该接口的队列都应该自己保证其线程安全
 * @author Administrator
 *
 * @param <V>
 */
public interface ICommandQueue<V> {

	/**
	 * 下一执行命令
	 * 
	 * @return
	 */
	V poll();

	/**
	 * 增加执行指令
	 * 
	 * @param value
	 * @return
	 */
	boolean offer(V value);

	/**
	 * 清理
	 */
	void clear();

	/**
	 * 获取指令数量
	 * 
	 * @return
	 */
	int size();

	boolean isRunning();

	void setRunning(boolean running);
	
	void setName(String name);
	
	String getName();
}
