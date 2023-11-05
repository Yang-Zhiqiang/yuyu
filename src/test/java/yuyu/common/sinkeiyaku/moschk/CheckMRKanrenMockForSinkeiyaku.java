package yuyu.common.sinkeiyaku.moschk;

/**
 * {@link CheckMRKanren}のモッククラスです。<br />
 */
public class CheckMRKanrenMockForSinkeiyaku extends CheckMRKanren {

    public static Class<?> caller = null;

    @Override
    public void exec(MosnaiCheckParam pMp) {
        if (caller == CheckSentakujyouhouTest_exec.class) {
            return;
        }

        super.exec(pMp);
    }
}
