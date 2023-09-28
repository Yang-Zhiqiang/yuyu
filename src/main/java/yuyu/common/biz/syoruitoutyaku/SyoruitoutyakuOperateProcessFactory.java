package yuyu.common.biz.syoruitoutyaku;

import java.util.Map;

import com.google.common.collect.Maps;

import yuyu.def.MessageId;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

/**
 * 業務共通 書類到着 書類到着時工程操作クラス生成ファクトリ
 */
public class SyoruitoutyakuOperateProcessFactory {

    private static Map<String, String> syoruitoutyakuMap = getSyoruitoutyakuMap();

    private static Map<String,String> getSyoruitoutyakuMap(){

        Map<String,String> map = Maps.newConcurrentMap();
        map.put("sinkeiyaku", "yuyu.common.sinkeiyaku.syoruitoutyaku.SinkeiyakuSyoruitoutyakuOperateProcess");
        map.put("hozen"     , "yuyu.common.hozen.syoruitoutyaku.HozenSyoruitoutyakuOperateProcess");
        map.put("siharai"   , "yuyu.common.siharai.syoruitoutyaku.SiharaiSyoruitoutyakuOperateProcess");
        map.put("nenkin"    , "yuyu.common.nenkin.syoruitoutyaku.NenkinSyoruitoutyakuOperateProcess");

        return map;
    }

    public SyoruitoutyakuOperateProcess exec(String pSubsystemId) {

        if (syoruitoutyakuMap.containsKey(pSubsystemId) == false) {

            throw new BizAppException(MessageId.EBA0023, "サブシステムID:" + pSubsystemId );
        }

        return getInstance(syoruitoutyakuMap.get(pSubsystemId));
    }

    private SyoruitoutyakuOperateProcess getInstance(String pPackage) {

        try {
            return (SyoruitoutyakuOperateProcess)SWAKInjector.getInstance(Class.forName(pPackage));

        } catch (ClassNotFoundException e) {
            throw new BizAppException(e, MessageId.EBF0011);
        }
    }

}
