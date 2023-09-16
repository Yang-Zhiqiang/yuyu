package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.mapping.GenIT_KhBikinkanri;

/**
 * 契約保全備金管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhBikinkanri} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhBikinkanri<br />
 * @see     PKIT_KhBikinkanri<br />
 * @see     QIT_KhBikinkanri<br />
 * @see     GenQIT_KhBikinkanri<br />
 */
@Entity
public class IT_KhBikinkanri extends GenIT_KhBikinkanri {

    private static final long serialVersionUID = 1L;

    public IT_KhBikinkanri() {
    }

    public IT_KhBikinkanri(String pSyono,BizDate pKessankijyunymd,C_BkncdKbn pBkncdkbn,BizDate pBknkktymd,Integer pRenno) {
        super(pSyono,pKessankijyunymd,pBkncdkbn,pBknkktymd,pRenno);
    }



}

