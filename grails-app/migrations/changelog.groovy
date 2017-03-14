databaseChangeLog = {

    changeSet(author: "zhena (generated)", id: "1489465048984-1") {
        createSequence(sequenceName: "hibernate_sequence")
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-2") {
        createTable(tableName: "login_authenticity") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "login_authenticityPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "access_token", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-3") {
        createTable(tableName: "login_authenticity_role") {
            column(name: "login_authenticity_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-4") {
        createTable(tableName: "request_map") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "request_mapPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "config_attribute", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "http_method", type: "VARCHAR(255)")

            column(name: "url", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-5") {
        createTable(tableName: "role") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "rolePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-6") {
        createTable(tableName: "role_hierarchy_entry") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "role_hierarchy_entryPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "entry", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-7") {
        addPrimaryKey(columnNames: "login_authenticity_id, role_id", constraintName: "login_authenticity_rolePK", tableName: "login_authenticity_role")
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-8") {
        addUniqueConstraint(columnNames: "username", constraintName: "UC_LOGIN_AUTHENTICITYUSERNAME_COL", tableName: "login_authenticity")
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-9") {
        addUniqueConstraint(columnNames: "authority", constraintName: "UC_ROLEAUTHORITY_COL", tableName: "role")
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-10") {
        addUniqueConstraint(columnNames: "entry", constraintName: "UC_ROLE_HIERARCHY_ENTRYENTRY_COL", tableName: "role_hierarchy_entry")
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-11") {
        addUniqueConstraint(columnNames: "http_method, url", constraintName: "UKf721bf1f2340334e273dd57aedcb", tableName: "request_map")
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-12") {
        addForeignKeyConstraint(baseColumnNames: "login_authenticity_id", baseTableName: "login_authenticity_role", constraintName: "FK7eq9op5ttdybyvpfp1hra6cl8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "login_authenticity")
    }

    changeSet(author: "zhena (generated)", id: "1489465048984-13") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "login_authenticity_role", constraintName: "FKob6238fm8r61aew857rojogcg", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role")
    }
}
