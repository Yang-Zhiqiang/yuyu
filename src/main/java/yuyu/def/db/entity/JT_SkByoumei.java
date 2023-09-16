package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenJT_SkByoumei;


/**
 * 請求病名テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SkByoumei} の JavaDoc を参照してください。<br />
 * @see     GenJT_SkByoumei<br />
 * @see     PKJT_SkByoumei<br />
 * @see     QJT_SkByoumei<br />
 * @see     GenQJT_SkByoumei<br />
 */
@Entity
public class JT_SkByoumei extends GenJT_SkByoumei {

    private static final long serialVersionUID = 1L;

    public JT_SkByoumei() {
    }

    public JT_SkByoumei(String pSkno,String pSyono,Integer pSeikyuurirekino,Integer pUketukeno,Integer pRenno) {
        super(pSkno,pSyono,pSeikyuurirekino,pUketukeno,pRenno);
    }



    private JT_SkJiyuu jT_SkJiyuu ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SkByoumei.SKNO  , referencedColumnName=JT_SkJiyuu.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkByoumei.SYONO  , referencedColumnName=JT_SkJiyuu.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkByoumei.SEIKYUURIREKINO  , referencedColumnName=JT_SkJiyuu.SEIKYUURIREKINO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkByoumei.UKETUKENO  , referencedColumnName=JT_SkJiyuu.UKETUKENO, insertable=false, updatable=false)
    })
    public JT_SkJiyuu getSkJiyuu() {
        return jT_SkJiyuu;
    }

    public void setSkJiyuu(JT_SkJiyuu pJT_SkJiyuu) {
        this.jT_SkJiyuu = pJT_SkJiyuu;
    }

    private JM_Byoumei jM_Byoumei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=JT_SkByoumei.BYOUMEITOUROKUNO  , referencedColumnName=JM_Byoumei.BYOUMEITOUROKUNO, insertable=false, updatable=false)
    })
    public  JM_Byoumei getByoumei() {
        return jM_Byoumei;
    }

    public void setByoumei(JM_Byoumei pJM_Byoumei) {
        this.jM_Byoumei = pJM_Byoumei;
    }

}

