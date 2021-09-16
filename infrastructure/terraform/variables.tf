####################################################################################################
# Global variables
####################################################################################################

variable "prefix" {
  type    = string
  default = "catenacax1"
}

variable "location" {
  type    = string
  default = "germanywestcentral"
}

variable "workspace_to_environment_map" {
  type = "map"
  default = {
    dev     = "dev"
    int     = "int"
    prod    = "prod"
  }
}

variable "environment_to_size_map" {
  type = "map"
  default = {
    dev     = "small"
    int     = "medium"
    prod    = "large"
  }
}

variable "size_to_node_count" {
  type = "map"
  default = {
    small     = 2
    medium    = 3
    prod      = 4
  }
}