package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_AccessLogSyousai;
import yuyu.def.db.mapping.GenAT_AccessLogSyousai;
import yuyu.def.db.meta.GenQAT_AccessLogSyousai;
import yuyu.def.db.meta.QAT_AccessLogSyousai;

/**
 * アクセスログ詳細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_AccessLogSyousai} の JavaDoc を参照してください。
 * @see     GenAT_AccessLogSyousai
 * @see     PKAT_AccessLogSyousai
 * @see     QAT_AccessLogSyousai
 * @see     GenQAT_AccessLogSyousai
 */
@Entity
public class AT_AccessLogSyousai extends GenAT_AccessLogSyousai {

    private static final long serialVersionUID = 1L;

    public AT_AccessLogSyousai() {
    }

    public AT_AccessLogSyousai(String pLogId, Long pSyousaiEdaNo) {
        super(pLogId, pSyousaiEdaNo);
    }

    private AT_AccessLog aT_AccessLog;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_AccessLogSyousai.LOGID, referencedColumnName=AT_AccessLog.LOGID, insertable=false, updatable=false)
    public AT_AccessLog getAccessLog() {
        return aT_AccessLog;
    }

    public void setAccessLog(AT_AccessLog pAT_AccessLog) {
        aT_AccessLog = pAT_AccessLog;
    }

}
