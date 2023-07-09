CREATE TABLE HT_SkLincJyusinData (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     linckyknaiykekdatarenno                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＬＩＮＣ契約内容結果データ連番 */
     linckyknaiykekdatarennooya                         VARCHAR     (10)                                                                ,  /* ＬＩＮＣ契約内容結果データ連番（親） */
     lincsousinymd                                      VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿送信日 */
     lincdatasyubetu                                    VARCHAR     (2)                                                                 ,  /* ＬＩＮＣ＿データ種別 */
     lincsoujyusinsyskbn                                VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ送受信用システム区分 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     rendoumosnochknasi                                 VARCHAR     (20)                                                                ,  /* 連動用申込番号（チェックなし） */
     lincrecordsyubetu                                  NUMBER      (2)                                                                 ,  /* ＬＩＮＣ＿レコード種別 */
     linchenkoutype                                     VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ＿変更タイプ */
     lincsyorikekkakekkacd                              NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿処理結果_結果コード */
     lincsyorikekkakekkajiyu                            NUMBER      (2)                                                                 ,  /* ＬＩＮＣ＿処理結果_結果事由 */
     lincsyorikekkaerrkouban                            NUMBER      (3)                                                                 ,  /* ＬＩＮＣ＿処理結果_エラー項番 */
     lincnayoserecordsuu                                NUMBER      (3)                                                                 ,  /* ＬＩＮＣ＿名寄せレコード数 */
     linckanyuusyano                                    NUMBER      (12)                                                                ,  /* ＬＩＮＣ＿加入者番号 */
     lincnayoseyomiknnm                                 VARCHAR     (32)                                                                ,  /* ＬＩＮＣ＿名寄せ読みカナ氏名 */
     linchhknnmkn                                       VARCHAR     (32)                                                                ,  /* ＬＩＮＣ＿被保険者名（カナ） */
     linchhknnmkj                                       VARCHAR     (30)                                                                ,  /* ＬＩＮＣ＿被保険者名（漢字） */
     linchhknsei                                        NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿被保険者性別 */
     linchhknseiymd                                     VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿被保険者生年月日 */
     linchhknadrkn                                      VARCHAR     (30)                                                                ,  /* ＬＩＮＣ＿被保険者住所（カナ） */
     linckeihidjnhyouji                                 VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ＿契被同人表示 */
     linckyknmkn                                        VARCHAR     (42)                                                                ,  /* ＬＩＮＣ＿契約者名（カナ） */
     linckyknmkj                                        VARCHAR     (30)                                                                ,  /* ＬＩＮＣ＿契約者名（漢字） */
     linckyksei                                         NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿契約者性別 */
     linckykseiymd                                      VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿契約者生年月日 */
     linckykadrkn                                       VARCHAR     (30)                                                                ,  /* ＬＩＮＣ＿契約者住所（カナ） */
     linckjhngflg                                       NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿漢字範囲外フラグ */
     linctrkmousideymd                                  VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿登録申出年月日 */
     linckykytymd                                       VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿契約予定年月日 */
     linckykymd                                         VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿契約年月日 */
     linchozenytymd                                     VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿保全予定年月日 */
     linchozenymd                                       VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿保全年月日 */
     lincsousinmotokaisya                               VARCHAR     (2)                                                                 ,  /* ＬＩＮＣ＿送信元会社 */
     lincsgnyukyhng                                     NUMBER      (5)                                                                 ,  /* ＬＩＮＣ＿災害入院給付金日額 */
     lincsgnyukyhng$                                    VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿災害入院給付金日額(通貨型) */
     lincsipnyukyhng                                    NUMBER      (5)                                                                 ,  /* ＬＩＮＣ＿疾病入院給付金日額 */
     lincsipnyukyhng$                                   VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿疾病入院給付金日額(通貨型) */
     lincsjnyukyhng                                     NUMBER      (5)                                                                 ,  /* ＬＩＮＣ＿成人病入院給付金日額 */
     lincsjnyukyhng$                                    VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿成人病入院給付金日額(通貨型) */
     lincsonotanyukyhng                                 NUMBER      (5)                                                                 ,  /* ＬＩＮＣ＿その他入院給付金日額 */
     lincsonotanyukyhng$                                VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿その他入院給付金日額(通貨型) */
     linchutuusbs                                       NUMBER      (10)                                                                ,  /* ＬＩＮＣ＿普通死亡保険金額 */
     linchutuusbs$                                      VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿普通死亡保険金額(通貨型) */
     lincsgsbksns                                       NUMBER      (10)                                                                ,  /* ＬＩＮＣ＿災害死亡時加算保険金額 */
     lincsgsbksns$                                      VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿災害死亡時加算保険金額(通貨型) */
     linc15sai1000manflg                                NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿１５歳未満１０００万超フラグ */
     linclincsyoriymd                                   VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿ＬＩＮＣ処理日 */
     linckykkanrino                                     VARCHAR     (40)                                                                ,  /* ＬＩＮＣ＿契約管理番号 */
     linckakusyasiyouran                                VARCHAR     (40)                                                                ,  /* ＬＩＮＣ＿各社使用欄 */
     lincmousideflg                                     NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿申出フラグ */
     lincmousideflgsetymd                               VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿申出フラグ設定年月日 */
     lincmousideflgkaijyoymd                            VARCHAR     (8)                                                                 ,  /* ＬＩＮＣ＿申出フラグ解除年月日 */
     lincjgyhknflg                                      NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿事業保険フラグ */
     linctenkanflg                                      NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿転換フラグ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_SkLincJyusinData ADD CONSTRAINT PK_SkLincJyusinData PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     linckyknaiykekdatarenno                                    /* ＬＩＮＣ契約内容結果データ連番 */
) ;
