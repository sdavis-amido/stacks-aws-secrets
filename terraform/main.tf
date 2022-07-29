resource "aws_secretsmanager_secret" "stacks-secret-1" {
   name = "/stacks-secret/example-1/"
}
 
resource "aws_secretsmanager_secret_version" "stacks-secret-1-v1" {
  secret_id = aws_secretsmanager_secret.stacks-secret-1.id
  secret_string = <<EOF
   {
    "stacks-secret-1": "SECRET-VALUE-1",
    "stacks-secret-2": "SECRET-VALUE-2",
   }
EOF
}

resource "aws_secretsmanager_secret" "stacks-secret-2" {
   name = "/stacks-secret/example-2/"
}

resource "aws_secretsmanager_secret_version" "stacks-secret-2-v1" {
  secret_id = aws_secretsmanager_secret.stacks-secret-2.id
  secret_string = <<EOF
   {
    "stacks-secret-3": "SECRET-VALUE-3",
    "stacks-secret-4": "SECRET-VALUE-4",
   }
EOF
}
