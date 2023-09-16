package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import yuyu.def.db.id.PKAT_AccessLog;
import yuyu.def.db.mapping.GenAT_AccessLog;
import yuyu.def.db.meta.GenQAT_AccessLog;
import yuyu.def.db.meta.QAT_AccessLog;

import com.google.common.collect.Lists;

/**
 * アクセスログテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_AccessLog} の JavaDoc を参照してください。
 * @see     GenAT_AccessLog
 * @see     PKAT_AccessLog
 * @see     QAT_AccessLog
 * @see     GenQAT_AccessLog
 */
@Entity
public class AT_AccessLog extends GenAT_AccessLog {

    private static final long serialVersionUID = 1L;

    public AT_AccessLog() {
    }

    public AT_AccessLog(String pLogId) {
        super(pLogId);
    }

    private List<AT_AccessLogSyousai> aT_AccessLogSyousais = Lists.newLinkedList();

    public AT_AccessLogSyousai createAccessLogSyousai() {
        AT_AccessLogSyousai aT_AccessLogSyousai = new AT_AccessLogSyousai();
        aT_AccessLogSyousai.setAccessLog(this);
        aT_AccessLogSyousai.setLogId(this.getLogId());
        getAccessLogSyousais().add(aT_AccessLogSyousai);
        return aT_AccessLogSyousai;
    }

    @OneToMany(
        cascade       = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH },
        orphanRemoval = true
        )
    @JoinColumn(name=AT_AccessLogSyousai.LOGID, referencedColumnName=AT_AccessLog.LOGID, insertable=false, updatable=false)
    public List<AT_AccessLogSyousai> getAccessLogSyousais() {
        return aT_AccessLogSyousais;
    }

    public void setAccessLogSyousais(List<AT_AccessLogSyousai> pAT_AccessLogSyousais) {
        aT_AccessLogSyousais = pAT_AccessLogSyousais;
    }

    public AT_AccessLogSyousai getAccessLogSyousai(long pSyousaiEdaNo) {
        for (AT_AccessLogSyousai accessLogSyousai : getAccessLogSyousais()) {
            if (accessLogSyousai.getSyousaiEdaNo().longValue() == pSyousaiEdaNo) {
                return accessLogSyousai;
            }
        }
        return null;
    }

    public void deleteKinouMode(long pSyousaiEdaNo) {
        AT_AccessLogSyousai accessLogSyousai = getAccessLogSyousai(pSyousaiEdaNo);
        if (accessLogSyousai != null) {
            getAccessLogSyousais().remove(accessLogSyousai);
        }
    }

}
