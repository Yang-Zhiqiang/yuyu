package yuyu.common.bosyuu.inject;

import jp.co.slcs.swak.core.inject.AbstractSWAKModule;

/**
 * Web・バッチ共通部品をバインドするための Module です。<br />
 * Web用Module・バッチ用Module の中で、この Module を install() してください。
 */
public class BosyuuCommonModule extends AbstractSWAKModule {

    @Override
    protected void configure() {
    }
}
