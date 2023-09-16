package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.mapping.GenJT_SiBikinkanri;

/**
 * 保険金給付金備金管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiBikinkanri} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiBikinkanri<br />
 * @see     PKJT_SiBikinkanri<br />
 * @see     QJT_SiBikinkanri<br />
 * @see     GenQJT_SiBikinkanri<br />
 */
@Entity
public class JT_SiBikinkanri extends GenJT_SiBikinkanri {

    private static final long serialVersionUID = 1L;

    public JT_SiBikinkanri() {
    }

    public JT_SiBikinkanri(String pSkno,String pSyono,BizDate pKessankijyunymd,C_BkncdKbn pBkncdkbn,BizDate pBknkktymd,String pKyuuhucd) {
        super(pSkno,pSyono,pKessankijyunymd,pBkncdkbn,pBknkktymd,pKyuuhucd);
    }



}

