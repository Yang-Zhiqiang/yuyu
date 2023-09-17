package yuyu.def.base.configuration;

/**
 * 特殊な機能定義Entityを返す必要がある機能を表す特殊機能定義クラスです。<br />
 * yuyu-base-config.xml の yuyuBaseConfig / tokusyuKinous / tokusyuKinou が読み込まれ、
 * このクラスのインスタンスとなります。
 */
public class TokusyuKinou extends GenTokusyuKinou {

    private static final long serialVersionUID = 1L;

    private Class<?> actionClass;

    public TokusyuKinou() {
    }

    public TokusyuKinou(String pActionClassName, String pInitMethod, String pKinouId) {
        setActionClassName(pActionClassName);
        setInitMethod(pInitMethod);
        setKinouId(pKinouId);
    }

    @Override
    public void setActionClassName(String pActionClass) {
        if (pActionClass == null) {
            actionClass = null;
            return;
        }
        super.setActionClassName(pActionClass);
        try {
            actionClass = Class.forName(pActionClass);
        } catch (ClassNotFoundException e) {
            actionClass = null;
        }
    }

    public Class<?> getActionClass() {
        return actionClass;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ actionClass:");
        sb.append(getActionClassName());
        if (getActionClass() == null) {
            sb.append(" (not exist)");
        }
        sb.append(", initMethod:");
        sb.append(getInitMethod());
        sb.append(", kinouId:");
        sb.append(getKinouId());
        sb.append(" }");
        return sb.toString();
    }
}
