export const SITE = {
  title: "Sidskipedia",
  description: "This wiki is to write down things I learn both at and outside of school, such as server operation, self-hosting, etc.",
  defaultLanguage: "en_US",
  github: "sindrekjelsrud",
  linkedin: "sindrekjelsrud",
};

export const OPEN_GRAPH = {
  image: {
    src: "",
    alt: "",
  }
};

export const SIDEBAR = [
  { text: "Machines", header: true },
  { text: "Kanto", link: "/machines/kanto" },

  { text: "Instructions", header: true },
  { text: "Wireguard", link: "/instructions/wireguard" },

  { text: "Services", header: true },
  { text: "Sidbot", link: "/services/sidbot" },
  { text: "SidsIgloo Minecraft Server", link: "/services/minecraft_server" },

  { text: "Random", header: true },
  { text: "OS Commands", link: "/random/os_commands" },
  { text: "Wii", link: "/random/wii" },
];
