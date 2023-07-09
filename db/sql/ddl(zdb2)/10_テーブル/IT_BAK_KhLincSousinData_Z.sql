CREATE TABLE IT_BAK_KhLincSousinData_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     lincsousinkbn                                      VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ送信区分 */
     lincrecordsyubetu                                  DECIMAL     (2)                                                                 ,  /* ＬＩＮＣ＿レコード種別 */
     linchenkoutype                                     VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ＿変更タイプ */
     linckanyuusyano                                    DECIMAL     (12)                                                                ,  /* ＬＩＮＣ＿加入者番号 */
     linchhknnmkn                                       VARCHAR     (32)                                                                ,  /* ＬＩＮＣ＿被保険者名（カナ） */
     linchhknnmkj                                       VARCHAR     (62)                                                                ,  /* ＬＩＮＣ＿被保険者名（漢字） */
     linchhknsei                                        DECIMAL     (1)                                                                 ,  /* ＬＩＮＣ＿被保険者性別 */
     linchhknseiymd                                     VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿被保険者生年月日 */
     linchhknadrkn                                      VARCHAR     (30)                                                                ,  /* ＬＩＮＣ＿被保険者住所（カナ） */
     linckeihidjnhyouji                                 VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ＿契被同人表示 */
     linckyknmkn                                        VARCHAR     (42)                                                                ,  /* ＬＩＮＣ＿契約者名（カナ） */
     linckyknmkj                                        VARCHAR     (62)                                                                ,  /* ＬＩＮＣ＿契約者名（漢字） */
     linckyksei                                         DECIMAL     (1)                                                                 ,  /* ＬＩＮＣ＿契約者性別 */
     linckykseiymd                                      VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿契約者生年月日 */
     linckykadrkn                                       VARCHAR     (30)                                                                ,  /* ＬＩＮＣ＿契約者住所（カナ） */
     linctrkmousideymd                                  VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿登録申出年月日 */
     linckykytymd                                       VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿契約予定年月日 */
     linckykymd                                         VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿契約年月日 */
     linchozenytymd                                     VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿保全予定年月日 */
     linchozenymd                                       VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿保全年月日 */
     lincsgnyukyhng                                     DECIMAL     (5)                                                                 ,  /* ＬＩＮＣ＿災害入院給付金日額 */
     lincsgnyukyhng$                                    VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿災害入院給付金日額(通貨型) */
     lincsipnyukyhng                                    DECIMAL     (5)                                                                 ,  /* ＬＩＮＣ＿疾病入院給付金日額 */
     lincsipnyukyhng$                                   VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿疾病入院給付金日額(通貨型) */
     lincsjnyukyhng                                     DECIMAL     (5)                                                                 ,  /* ＬＩＮＣ＿成人病入院給付金日額 */
     lincsjnyukyhng$                                    VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿成人病入院給付金日額(通貨型) */
     lincsonotanyukyhng                                 DECIMAL     (5)                                                                 ,  /* ＬＩＮＣ＿その他入院給付金日額 */
     lincsonotanyukyhng$                                VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿その他入院給付金日額(通貨型) */
     linchutuusbs                                       DECIMAL     (10)                                                                ,  /* ＬＩＮＣ＿普通死亡保険金額 */
     linchutuusbs$                                      VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿普通死亡保険金額(通貨型) */
     lincsgsbksns                                       DECIMAL     (10)                                                                ,  /* ＬＩＮＣ＿災害死亡時加算保険金額 */
     lincsgsbksns$                                      VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿災害死亡時加算保険金額(通貨型) */
     linckakusyasiyouran                                VARCHAR     (40)                                                                ,  /* ＬＩＮＣ＿各社使用欄 */
     lincmousideflg                                     DECIMAL     (1)                                                                 ,  /* ＬＩＮＣ＿申出フラグ */
     lincmousideflgsetymd                               VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿申出フラグ設定年月日 */
     lincmousideflgkaijyoymd                            VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿申出フラグ解除年月日 */
     lincjgyhknflg                                      DECIMAL     (1)                                                                 ,  /* ＬＩＮＣ＿事業保険フラグ */
     linctenkanflg                                      DECIMAL     (1)                                                                 ,  /* ＬＩＮＣ＿転換フラグ */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_BAK_KhLincSousinData_Z ADD CONSTRAINT PK_BAK_KhLincSousinData PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     syoriYmd                                                 , /* 処理年月日 */
     renno                                                      /* 連番 */
) ;
