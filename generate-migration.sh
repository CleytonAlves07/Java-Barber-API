#!/bin/bash

MIGRATIONS_DIR="src/main/resources/db/migration"
TIMESTAMP=$(date +"%Y%m%d%H%M%S")

if [ -z "$1" ]; then
  echo "Erro: Você deve fornecer um nome para a migração."
  echo "Uso: ./generate-migration.sh <nome_da_migracao>"
  exit 1
fi

MIGRATION_NAME="V${TIMESTAMP}__$1.sql"
MIGRATION_FILE="${MIGRATIONS_DIR}/${MIGRATION_NAME}"

if [ ! -d "$MIGRATIONS_DIR" ]; then
  mkdir -p "$MIGRATIONS_DIR"
fi

touch "$MIGRATION_FILE"
echo "-- ${MIGRATION_NAME} generated in ${MIGRATIONS_DIR}" > "$MIGRATION_FILE"

echo "Arquivo de migração criado: ${MIGRATION_FILE}"