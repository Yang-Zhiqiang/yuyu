package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.db.mapping.GenJT_SkKkn;


/**
 * 請求期間テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SkKkn} の JavaDoc を参照してください。<br />
 * @see     GenJT_SkKkn<br />
 * @see     PKJT_SkKkn<br />
 * @see     QJT_SkKkn<br />
 * @see     GenQJT_SkKkn<br />
 */
@Entity
public class JT_SkKkn extends GenJT_SkKkn {

    private static final long serialVersionUID = 1L;

    public JT_SkKkn() {
    }

    public JT_SkKkn(String pSkno,String pSyono,Integer pSeikyuurirekino,Integer pUketukeno,C_KyuuhuKbn pKyuuhukbn,Integer pRenno) {
        super(pSkno,pSyono,pSeikyuurirekino,pUketukeno,pKyuuhukbn,pRenno);
    }



    private JT_SkJiyuu jT_SkJiyuu ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SkKkn.SKNO  , referencedColumnName=JT_SkJiyuu.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkKkn.SYONO  , referencedColumnName=JT_SkJiyuu.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkKkn.SEIKYUURIREKINO  , referencedColumnName=JT_SkJiyuu.SEIKYUURIREKINO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkKkn.UKETUKENO  , referencedColumnName=JT_SkJiyuu.UKETUKENO, insertable=false, updatable=false)
    })
    public JT_SkJiyuu getSkJiyuu() {
        return jT_SkJiyuu;
    }

    public void setSkJiyuu(JT_SkJiyuu pJT_SkJiyuu) {
        this.jT_SkJiyuu = pJT_SkJiyuu;
    }

    private JM_Syujyutu jM_Syujyutu ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=JT_SkKkn.SYUJYUTUTOUROKUNO  , referencedColumnName=JM_Syujyutu.SYUJYUTUTOUROKUNO, insertable=false, updatable=false)
    })
    public  JM_Syujyutu getSyujyutu() {
        return jM_Syujyutu;
    }

    public void setSyujyutu(JM_Syujyutu pJM_Syujyutu) {
        this.jM_Syujyutu = pJM_Syujyutu;
    }

}

