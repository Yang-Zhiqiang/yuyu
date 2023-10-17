package yuyu.app.workflow.imagekanri.imagetorikomi;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * イメージ取込 のビジネスロジックです。
 */
public class ImageTorikomiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private ImageTorikomiUiBean uiBean;

    void init() {
        clear();
    }

    void clear() {
    }
}
