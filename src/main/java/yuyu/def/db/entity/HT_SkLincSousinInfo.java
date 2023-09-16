package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.mapping.GenHT_SkLincSousinInfo;


/**
 * 新契約ＬＩＮＣ送信情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkLincSousinInfo} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkLincSousinInfo<br />
 * @see     PKHT_SkLincSousinInfo<br />
 * @see     QHT_SkLincSousinInfo<br />
 * @see     GenQHT_SkLincSousinInfo<br />
 */
@Entity
public class HT_SkLincSousinInfo extends GenHT_SkLincSousinInfo {

    private static final long serialVersionUID = 1L;

    public HT_SkLincSousinInfo() {
    }

    public HT_SkLincSousinInfo(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,String pMosno,Integer pRenno) {
        super(pLincsoujyusinsyskbn,pMosno,pRenno);
    }



}

