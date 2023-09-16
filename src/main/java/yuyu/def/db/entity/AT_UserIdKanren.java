package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenAT_UserIdKanren;
import yuyu.def.db.meta.GenQAT_UserIdKanren;
import yuyu.def.db.meta.QAT_UserIdKanren;

/**
 * ユーザーＩＤ関連テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_UserIdKanren} の JavaDoc を参照してください。
 * @see     GenAT_UserIdKanren
 * @see     PKAT_UserIdKanren
 * @see     QAT_UserIdKanren
 * @see     GenQAT_UserIdKanren
 */
@Entity
public class AT_UserIdKanren extends GenAT_UserIdKanren {

    private static final long serialVersionUID = 1L;

    public AT_UserIdKanren() {
    }

    public AT_UserIdKanren(String pIdkbn, String pIdcd) {
        super(pIdkbn,pIdcd);
    }


  
    private AM_IdCard aM_IdCard ;

    @ManyToOne (fetch = FetchType.LAZY,
                       cascade = { CascadeType.DETACH }
                       )
    @JoinColumns({
        @JoinColumn(name=AT_UserIdKanren.IDKBN  , referencedColumnName=AM_IdCard.IDKBN, insertable=false, updatable=false),
        @JoinColumn(name=AT_UserIdKanren.IDCD  , referencedColumnName=AM_IdCard.IDCD, insertable=false, updatable=false)
    })
    public  AM_IdCard getIdCard() {
        return aM_IdCard;
    }

    public void setIdCard(AM_IdCard pAM_IdCard) {
        this.aM_IdCard = pAM_IdCard;
    }

}

