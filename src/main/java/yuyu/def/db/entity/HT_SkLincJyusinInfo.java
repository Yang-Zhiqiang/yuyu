package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.mapping.GenHT_SkLincJyusinInfo;


/**
 * 新契約ＬＩＮＣ受信情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkLincJyusinInfo} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkLincJyusinInfo<br />
 * @see     PKHT_SkLincJyusinInfo<br />
 * @see     QHT_SkLincJyusinInfo<br />
 * @see     GenQHT_SkLincJyusinInfo<br />
 */
@Entity
public class HT_SkLincJyusinInfo extends GenHT_SkLincJyusinInfo {

    private static final long serialVersionUID = 1L;

    public HT_SkLincJyusinInfo() {
    }

    public HT_SkLincJyusinInfo(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,String pLinckyknaiykekdatarenno,BizDate pSyoriYmd,String pMosno,BizNumber pRenno2,BizDate pSousinymd) {
        super(pLincsoujyusinsyskbn,pLinckyknaiykekdatarenno,pSyoriYmd,pMosno,pRenno2,pSousinymd);
    }



}

