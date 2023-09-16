package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.mapping.GenST_ConvertKanjyouKamoku;


/**
 * 勘定科目変換テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_ConvertKanjyouKamoku} の JavaDoc を参照してください。<br />
 * @see     GenST_ConvertKanjyouKamoku<br />
 * @see     PKST_ConvertKanjyouKamoku<br />
 * @see     QST_ConvertKanjyouKamoku<br />
 * @see     GenQST_ConvertKanjyouKamoku<br />
 */
@Entity
public class ST_ConvertKanjyouKamoku extends GenST_ConvertKanjyouKamoku {

    private static final long serialVersionUID = 1L;

    public ST_ConvertKanjyouKamoku() {
    }

    public ST_ConvertKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd,C_TaisyakuKbn pTaisyakukbn) {
        super(pKanjyoukmkcd,pTaisyakukbn);
    }



    private BM_KanjyouKamoku bM_KanjyouKamokuKan ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=ST_ConvertKanjyouKamoku.KANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
    })
    public  BM_KanjyouKamoku getKanjyouKamokuKan() {
        return bM_KanjyouKamokuKan;
    }

    public void setKanjyouKamokuKan(BM_KanjyouKamoku pBM_KanjyouKamoku) {
        this.bM_KanjyouKamokuKan = pBM_KanjyouKamoku;
    }

    private BM_KanjyouKamoku bM_KanjyouKamokuConverted ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=ST_ConvertKanjyouKamoku.CONVERTEDKANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
    })
    public  BM_KanjyouKamoku getKanjyouKamokuConverted() {
        return bM_KanjyouKamokuConverted;
    }

    public void setKanjyouKamokuConverted(BM_KanjyouKamoku pBM_KanjyouKamoku) {
        this.bM_KanjyouKamokuConverted = pBM_KanjyouKamoku;
    }

}

