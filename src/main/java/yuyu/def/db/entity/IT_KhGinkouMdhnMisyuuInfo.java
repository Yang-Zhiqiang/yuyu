package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhGinkouMdhnMisyuuInfo;

/**
 * 銀行窓販未収情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhGinkouMdhnMisyuuInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhGinkouMdhnMisyuuInfo<br />
 * @see     PKIT_KhGinkouMdhnMisyuuInfo<br />
 * @see     QIT_KhGinkouMdhnMisyuuInfo<br />
 * @see     GenQIT_KhGinkouMdhnMisyuuInfo<br />
 */
@Entity
public class IT_KhGinkouMdhnMisyuuInfo extends GenIT_KhGinkouMdhnMisyuuInfo {

    private static final long serialVersionUID = 1L;

    public IT_KhGinkouMdhnMisyuuInfo() {
    }

    public IT_KhGinkouMdhnMisyuuInfo(String pKbnkey,BizDate pDatarenymd,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pDatarenymd,pSyono,pHenkousikibetukey);
    }

    public IT_KhGinkouMdhnMisyuuInfo(BizDate pDatarenymd,String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pDatarenymd,pSyono,pHenkousikibetukey);
    }


}

