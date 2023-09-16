package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SiDetailKkn;


/**
 * 支払明細期間テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiDetailKkn} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiDetailKkn<br />
 * @see     PKJT_SiDetailKkn<br />
 * @see     QJT_SiDetailKkn<br />
 * @see     GenQJT_SiDetailKkn<br />
 */
@Entity
public class JT_SiDetailKkn extends GenJT_SiDetailKkn {

    private static final long serialVersionUID = 1L;

    public JT_SiDetailKkn() {
    }

    public JT_SiDetailKkn(String pSkno,String pSyono,Integer pSeikyuurirekino,Integer pUketukeno,String pKyuuhucd,Integer pRenno,Integer pRenno2keta2) {
        super(pSkno,pSyono,pSeikyuurirekino,pUketukeno,pKyuuhucd,pRenno,pRenno2keta2);
    }



    private JT_SkJiyuu jT_SkJiyuu ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SiDetailKkn.SKNO  , referencedColumnName=JT_SkJiyuu.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SiDetailKkn.SYONO  , referencedColumnName=JT_SkJiyuu.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SiDetailKkn.SEIKYUURIREKINO  , referencedColumnName=JT_SkJiyuu.SEIKYUURIREKINO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SiDetailKkn.UKETUKENO  , referencedColumnName=JT_SkJiyuu.UKETUKENO, insertable=false, updatable=false)
    })
    public JT_SkJiyuu getSkJiyuu() {
        return jT_SkJiyuu;
    }

    public void setSkJiyuu(JT_SkJiyuu pJT_SkJiyuu) {
        this.jT_SkJiyuu = pJT_SkJiyuu;
    }

}

