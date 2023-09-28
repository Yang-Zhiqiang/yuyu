package yuyu.common.biz.syoruitoutyaku;

import iwf.callback.arriveimage.ToutyakuYoteiInfo;
import iwf.callback.arriveimage.ToutyakuYoteiNotFound;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.MessageId;
import yuyu.def.classification.C_QrCodeTaikeiKbn;

/**
 * 業務共通 書類到着 書類到着時管理情報取得呼出し処理
 */
public class ExecGetSyoruitoutyakuInfo extends ToutyakuYoteiNotFound {

    @Override
    public ToutyakuYoteiInfo exec(String pToutyakuKey) {

        if (pToutyakuKey.length() < 4 || !C_QrCodeTaikeiKbn.MOS.getValue().equals(pToutyakuKey.substring(0, 3))) {
            throw new BizLogicException(MessageId.EBA0023,"文書ID");
        }

        GetSyoruitoutyakuInfo getSyoruitoutyakuInfo = null;

        try {
            getSyoruitoutyakuInfo = (GetSyoruitoutyakuInfo) SWAKInjector.getInstance(Class.forName("yuyu.common.sinkeiyaku.syoruitoutyaku.SinkeiyakuGetSyoruitoutyakuInfo"));
        }  catch (ClassNotFoundException e) {
            throw new BizAppException(e, MessageId.EBF0011);
        }

        return getSyoruitoutyakuInfo.exec(pToutyakuKey);
    }

}