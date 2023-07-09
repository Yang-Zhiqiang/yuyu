CREATE TABLE HT_SkLincSousinInfo (
     lincsoujyusinsyskbn                                VARCHAR     (1)                                                       NOT NULL  ,  /* ＬＩＮＣ送受信用システム区分                                */
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     lincsousinkbn                                      VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ送信区分                                      */
     lincrecordsyubetu                                  NUMBER      (2)                                                                 ,  /* ＬＩＮＣ＿レコード種別                                   */
     linchenkoutype                                     VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ＿変更タイプ                                    */
     linckanyuusyano                                    NUMBER      (12)                                                                ,  /* ＬＩＮＣ＿加入者番号                                    */
     linchhknnmkn                                       VARCHAR     (32)                                                                ,  /* ＬＩＮＣ＿被保険者名（カナ）                                */
     linchhknnmkj                                       VARCHAR     (30)                                                                ,  /* ＬＩＮＣ＿被保険者名（漢字）                                */
     linchhknsei                                        NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿被保険者性別                                   */
     linchhknseiymd                                     NUMBER      (8)                                                                 ,  /* ＬＩＮＣ＿被保険者生年月日                                 */
     linchhknadrkn                                      VARCHAR     (37)                                                                ,  /* ＬＩＮＣ＿被保険者住所（カナ）                               */
     linckeihidjnhyouji                                 NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿契被同人表示                                   */
     linckyknmkn                                        VARCHAR     (42)                                                                ,  /* ＬＩＮＣ＿契約者名（カナ）                                 */
     linckyknmkj                                        VARCHAR     (30)                                                                ,  /* ＬＩＮＣ＿契約者名（漢字）                                 */
     linckyksei                                         NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿契約者性別                                    */
     linckykseiymd                                      NUMBER      (8)                                                                 ,  /* ＬＩＮＣ＿契約者生年月日                                  */
     linckykadrkn                                       VARCHAR     (37)                                                                ,  /* ＬＩＮＣ＿契約者住所（カナ）                                */
     linctrkmousideymd                                  NUMBER      (8)                                                                 ,  /* ＬＩＮＣ＿登録申出年月日                                  */
     linckykytymd                                       NUMBER      (8)                                                                 ,  /* ＬＩＮＣ＿契約予定年月日                                  */
     linckykymd                                         NUMBER      (8)                                                                 ,  /* ＬＩＮＣ＿契約年月日                                    */
     linchozenytymd                                     NUMBER      (8)                                                                 ,  /* ＬＩＮＣ＿保全予定年月日                                  */
     linchozenymd                                       NUMBER      (8)                                                                 ,  /* ＬＩＮＣ＿保全年月日                                    */
     lincsgnyukyhng                                     NUMBER      (5)                                                                 ,  /* ＬＩＮＣ＿災害入院給付金日額                                */
     lincsgnyukyhng$                                    VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿災害入院給付金日額(通貨型)                           */
     lincsipnyukyhng                                    NUMBER      (5)                                                                 ,  /* ＬＩＮＣ＿疾病入院給付金日額                                */
     lincsipnyukyhng$                                   VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿疾病入院給付金日額(通貨型)                           */
     lincsjnyukyhng                                     NUMBER      (5)                                                                 ,  /* ＬＩＮＣ＿成人病入院給付金日額                               */
     lincsjnyukyhng$                                    VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿成人病入院給付金日額(通貨型)                          */
     lincsonotanyukyhng                                 NUMBER      (5)                                                                 ,  /* ＬＩＮＣ＿その他入院給付金日額                               */
     lincsonotanyukyhng$                                VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿その他入院給付金日額(通貨型)                          */
     linchutuusbs                                       NUMBER      (10)                                                                ,  /* ＬＩＮＣ＿普通死亡保険金額                                 */
     linchutuusbs$                                      VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿普通死亡保険金額(通貨型)                            */
     lincsgsbksns                                       NUMBER      (10)                                                                ,  /* ＬＩＮＣ＿災害死亡時加算保険金額                              */
     lincsgsbksns$                                      VARCHAR     (10)                                                                ,  /* ＬＩＮＣ＿災害死亡時加算保険金額(通貨型)                         */
     linckakusyasiyouran                                VARCHAR     (40)                                                                ,  /* ＬＩＮＣ＿各社使用欄                                    */
     lincmousideflg                                     NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿申出フラグ                                    */
     lincmousideflgsetymd                               NUMBER      (8)                                                                 ,  /* ＬＩＮＣ＿申出フラグ設定年月日                               */
     lincmousideflgkaijyoymd                            NUMBER      (8)                                                                 ,  /* ＬＩＮＣ＿申出フラグ解除年月日                               */
     lincjgyhknflg                                      NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿事業保険フラグ                                  */
     linctenkanflg                                      NUMBER      (1)                                                                 ,  /* ＬＩＮＣ＿転換フラグ                                    */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_SkLincSousinInfo ADD CONSTRAINT PK_SkLincSousinInfo PRIMARY KEY (
     lincsoujyusinsyskbn                                      , /* ＬＩＮＣ送受信用システム区分                                 */
     mosno                                                    , /* 申込番号                                           */
     renno                                                      /* 連番                                             */
) ;
