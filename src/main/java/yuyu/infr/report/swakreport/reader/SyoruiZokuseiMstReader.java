package yuyu.infr.report.swakreport.reader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.infr.report.swakreport.SyoruiZokusei;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;

/**
 * 書類属性マスタから書類属性情報を読み込む為のクラスです。<br />
 */
public class SyoruiZokuseiMstReader extends SyoruiZokuseiReader {

    @Override
    public Map<String, SyoruiZokusei> read() {
        final Map<String, SyoruiZokusei> syoruiZokuseiMap = new HashMap<String, SyoruiZokusei>();
        BaseDomManager baseDom = SWAKInjector.getInstance(BaseDomManager.class);

        List<AM_SyoruiZokusei> syoruiZokuseiList = baseDom.getAllSyoruiZokuseis();

        for(AM_SyoruiZokusei zokusei:syoruiZokuseiList){

            syoruiZokuseiMap.put(zokusei.getSyoruiCd().getValue(), new SyoruiZokusei(zokusei.getSyoruiCd(),
                    zokusei.getSyoruinm(),
                    zokusei.getSyoruinmryaku(),
                    zokusei.getTyouhyouid(),
                    zokusei.getHozonKikan(),
                    zokusei.getNengetukbn(),
                    zokusei.getAngoukaKbn(),
                    zokusei.getPdfHozonKbn(),
                    zokusei.getZipHozonKbn(),
                    zokusei.getPageCount(),
                    zokusei.getSortNo(),
                    zokusei.getKensakuKey1(),
                    zokusei.getKensakuKey2(),
                    zokusei.getKensakuKey3(),
                    zokusei.getKensakuKey4(),
                    zokusei.getKensakuKey5()));
        }

        return syoruiZokuseiMap;
    }

}
