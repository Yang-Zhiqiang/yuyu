package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.mapping.GenBT_Hjyblist;


/**
 * 補助簿リスト用テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_Hjyblist} の JavaDoc を参照してください。<br />
 * @see     GenBT_Hjyblist<br />
 * @see     PKBT_Hjyblist<br />
 * @see     QBT_Hjyblist<br />
 * @see     GenQBT_Hjyblist<br />
 */
@Entity
public class BT_Hjyblist extends GenBT_Hjyblist {

    private static final long serialVersionUID = 1L;

    public BT_Hjyblist() {
    }

    public BT_Hjyblist(String pHjybtantositucd,C_Kanjyoukmkcd pKanjyoukmkcd,String pSyorisyokantantcd,BizDate pDenymd) {
        super(pHjybtantositucd,pKanjyoukmkcd,pSyorisyokantantcd,pDenymd);
    }



    private BM_KanjyouKamoku bM_KanjyouKamoku ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_Hjyblist.KANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
    })
    public  BM_KanjyouKamoku getKanjyouKamoku() {
        return bM_KanjyouKamoku;
    }

    public void setKanjyouKamoku(BM_KanjyouKamoku pBM_KanjyouKamoku) {
        this.bM_KanjyouKamoku = pBM_KanjyouKamoku;
    }

}

