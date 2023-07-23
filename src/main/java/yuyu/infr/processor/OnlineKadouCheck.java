package yuyu.infr.processor;

/**
 * オンライン稼働チェックの親インタフェース<br />
 */
public interface OnlineKadouCheck {

    public boolean isOnlineKadouOnOnline();

    public boolean isOnlineKadouOnBatch();
}
