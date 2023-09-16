package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIW_KhHaitouTaisyouWK;
import yuyu.def.db.mapping.GenIW_KhHaitouTaisyouWK;
import yuyu.def.db.meta.GenQIW_KhHaitouTaisyouWK;
import yuyu.def.db.meta.QIW_KhHaitouTaisyouWK;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;

/**
 * 配当金算出対象抽出ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhHaitouTaisyouWK} の JavaDoc を参照してください。
 * @see     GenIW_KhHaitouTaisyouWK
 * @see     PKIW_KhHaitouTaisyouWK
 * @see     QIW_KhHaitouTaisyouWK
 * @see     GenQIW_KhHaitouTaisyouWK
 */
@Entity
public class IW_KhHaitouTaisyouWK extends GenIW_KhHaitouTaisyouWK {

    private static final long serialVersionUID = 1L;

    public IW_KhHaitouTaisyouWK() {
    }

    public IW_KhHaitouTaisyouWK(
        String pKbnkey,
        String pSyono,
        BizDate pSyoriYmd,
        C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn,
        Integer pRenno
        ) {
        super(
            pKbnkey,
            pSyono,
            pSyoriYmd,
            pHaitoukinuketorihoukbn,
            pHaitoumeisaikbn,
            pRenno
            );
    }

    public IW_KhHaitouTaisyouWK(String pSyono, BizDate pSyoriYmd, C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn, Integer pRenno) {
        super(
            SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),
            pSyono,
            pSyoriYmd,
            pHaitoukinuketorihoukbn,
            pHaitoumeisaikbn,
            pRenno
            );
    }

}
